import React, { useRef } from 'react';
import { MapContainer, TileLayer, Marker, Popup} from 'react-leaflet';
import 'leaflet/dist/leaflet.css';

import icon from "./constants";


function MapView() {

    const defaultCenter = [52.237049, 21.017532];
    const defaultZoom = 13;
    const mapRef = useRef();

    return (
        <MapContainer ref={mapRef} center={defaultCenter} zoom={defaultZoom} scrollWheelZoom={false}>
            <TileLayer url="https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png"/>

            <Marker position={defaultCenter} icon={icon}>
                <Popup>
                    A pretty CSS3 popup. <br /> Easily customizable.
                </Popup>
            </Marker>
        </MapContainer>

    );
}

export default MapView;