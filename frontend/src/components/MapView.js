import React, {useEffect, useRef, useState} from 'react';
import {MapContainer, Marker, Popup, TileLayer} from 'react-leaflet';
import 'leaflet/dist/leaflet.css';
import {defaultIcon} from './mapConfig';
import FetchService from "./FetchService";
import Translator from "./Translator";

function MapView({getResult}) {
    const [center, setCenter] = useState([52.237049, 21.017532]);
    const [zoom] = useState(13);
    const [address, setAddress] = useState('');
    const mapRef = useRef();

    useEffect(() => {
        const regionName = parseRegionName(getResult);
        if (!regionName) return;

        const processRegionName = async () => {
            try {
                const {lat, lon} = await FetchService.getCoordinates(regionName);
                setCenter([lat, lon]);
                setAddress(regionName);
            } catch (error) {
                console.error(error.message);
            }
        };

        processRegionName();
    }, [getResult]);


    useEffect(() => {
        if (mapRef.current) {
            mapRef.current.setView(center, zoom);
        }
    }, [center, zoom]);

    const parseRegionName = (input) => {
        if (typeof input === 'string') {
            try {
                input = JSON.parse(input);
            } catch {
                return null;
            }
        }
        if (Array.isArray(input) && input.length > 0) {
            let regionName = input[0];
            return Translator.containsCyrillic(regionName)
                ? Translator.translate(regionName)
                : regionName;
        }
        return null;
    };

    return (
        <MapContainer ref={mapRef} center={center} zoom={zoom} scrollWheelZoom={false}>
            <TileLayer url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"/>
            <Marker position={center} icon={defaultIcon}>
                <Popup>
                    {address || 'Loading address...'}
                </Popup>
            </Marker>
        </MapContainer>
    );
}

export default MapView;