class PlateService {
    constructor(apiClient, getRegionRef, setGetResult, setIsShown, regionRef) {
        this.apiClient = apiClient;
        this.getRegionRef = getRegionRef;
        this.setGetResult = setGetResult;
        this.setIsShown = setIsShown;
        this.regionRef = regionRef;
    }

    // Template method
    async getPlates(endpoint) {
        const regionValue = this.getRegionRef.current.value;
        const selectValue = this.regionRef.current.value;

        if (selectValue === 'None') {
            alert('Choose any country first');
            return;
        }

        if (regionValue === '') {
            alert('Choose region first');
            return;
        }

        try {
            const res = await this.apiClient.get(endpoint);
            const result = { information: res.data };
            this.setGetResult(this.formatResponse(result));
            this.getRegionRef.current.value = '';
            this.setIsShown(true);
        } catch (err) {
            if (!err?.response) {
                alert("No Server Response");
                return;
            }
            this.setGetResult(this.formatResponse(err.response?.data || err));
            this.getRegionRef.current.value = '';
        }
    }

    formatResponse(res) {
        return JSON.stringify(res, null, 2);
    }
}