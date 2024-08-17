import React from 'react';

function CountrySelect({countries, value, onChange, id, selectRef, imageId}) {
    return (
        <div className="country-select-container">
            <select value={value} id={id} onChange={onChange} className="form__input center" ref={selectRef}>
                <option value="None">Choose country</option>
                {countries.map(country => (
                    <option key={country.value} value={country.value}>
                        {country.flag}&emsp;{country.label}
                    </option>
                ))}
            </select>
        </div>
    );
}

export default CountrySelect;
