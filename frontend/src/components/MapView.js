import React, {useEffect, useRef, useState} from 'react';
import {MapContainer, Marker, Polyline, Popup, TileLayer} from 'react-leaflet';
import 'leaflet/dist/leaflet.css';
import {defaultIcon} from './mapConfig';
import FetchService from "./FetchService";
import Translator from "./Translator";

const haversineDistance = ([lat1, lon1], [lat2, lon2]) => {
    const toRad = (x) => (x * Math.PI) / 180;

    const R = 6371;
    const dLat = toRad(lat2 - lat1);
    const dLon = toRad(lon2 - lon1);
    const a =
        Math.sin(dLat / 2) * Math.sin(dLat / 2) +
        Math.cos(toRad(lat1)) * Math.cos(toRad(lat2)) *
        Math.sin(dLon / 2) * Math.sin(dLon / 2);
    const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
    return R * c;
};

function MapView({getResult}) {
    const initialCenter = useRef([52.237049, 21.017532]);
    const [center, setCenter] = useState(initialCenter.current);
    const [zoom] = useState(13);
    const [address, setAddress] = useState('');
    const [lineCoords, setLineCoords] = useState([]);
    const [distance, setDistance] = useState(null);
    const mapRef = useRef();

    const getCurrentCoordinates = () => {
        return new Promise((resolve, reject) => {
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(
                    (position) => {
                        const {latitude, longitude} = position.coords;
                        resolve([latitude, longitude]);
                    },
                    (error) => {
                        console.error("Error getting location: ", error);
                        reject(error);
                    }
                );
            } else {
                console.error("Geolocation is not supported by this browser.");
                reject("Geolocation not supported");
            }
        });
    };

    useEffect(() => {
        getCurrentCoordinates()
            .then(coords => {
                setCenter(coords);
            })
            .catch(error => {
                console.error(error);
            });
    }, []);

    useEffect(() => {
        const regionName = parseRegionName(getResult);
        if (!regionName) return;

        const processRegionName = async () => {
            try {
                const {lat, lon} = await FetchService.getCoordinates(regionName);
                const newCenter = [lat, lon];
                setCenter(newCenter);
                setAddress(regionName);

                const calculatedDistance = haversineDistance(initialCenter.current, newCenter);
                setDistance(calculatedDistance.toFixed(2));

                setLineCoords([initialCenter.current, newCenter]);
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
        <div>
            <MapContainer ref={mapRef} center={center} zoom={zoom} scrollWheelZoom={false}>
                <TileLayer url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"/>
                <Marker position={center} icon={defaultIcon}>
                    <Popup>
                        {address || 'Loading address...'}
                    </Popup>
                </Marker>
                {lineCoords.length === 2 && (
                    <Polyline positions={lineCoords} color="blue"/>
                )}
            </MapContainer>
            {}
            {distance && (
                <div className="distance-display">
                    Distance: {distance} km
                </div>
            )}
        </div>
    );
}

export default MapView;
