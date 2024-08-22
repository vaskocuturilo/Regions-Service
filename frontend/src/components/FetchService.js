class FetchService {
    static async getCoordinates(regionName) {
        const response = await fetch(`https://nominatim.openstreetmap.org/search?q=${encodeURIComponent(regionName)}&format=json&limit=1`);
        if (!response.ok) {
            throw new Error('Failed to fetch coordinates');
        }
        const data = await response.json();
        if (data.length === 0) {
            throw new Error('No results found for the given address');
        }
        return {lat: parseFloat(data[0].lat), lon: parseFloat(data[0].lon)};
    }
}

export default FetchService;