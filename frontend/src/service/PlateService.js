export class PlateService {
    constructor(apiClient, getRegionRef, setGetResult, setIsShown, regionRef) {
        this.apiClient = apiClient;
        this.getRegionRef = getRegionRef;
        this.setGetResult = setGetResult;
        this.setIsShown = setIsShown;
        this.regionRef = regionRef;
    }

    getErrorMessage(err) {
        const errorMessagesByCode = {
            'ECONNABORTED': 'Request timed out. Please try again later.',
        };

        const errorMessagesByStatus = {
            404: 'Region not found. Please check the region and try again.',
            500: 'Server error. Please try again later.',
        };

        return errorMessagesByCode[err?.code] ||
            (!err?.response ? 'No Server Response. Please check your network connection or try again later.' :
                errorMessagesByStatus[err.response.status] ||
                `An error occurred: ${err.response.status}. Please try again.`);
    }

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
            if (res && res.data) {
                const data = res.data

                if (!data) {
                    alert('No information found in the response.');
                    return;
                }

                const result = Array.isArray(data)
                    ? data.map(item => {
                        if (!item.description || !item.region) {
                            throw new Error('Incomplete data in one of the items.');
                        }
                        return [item.description, item.region];
                    })
                    : [data.description, data.region];
                this.setGetResult(this.formatResponse(result));
                this.getRegionRef.current.value = '';
                this.setIsShown(true);
            }
        } catch
            (err) {
            const message = this.getErrorMessage(err);
            alert(message);

            console.error("Error fetching plates by region:", err);

            this.setGetResult(this.formatResponse(err.response?.data || err));
            this.getRegionRef.current.value = '';
        }
    }

    formatResponse(res) {
        return JSON.stringify(res, null, 2);
    }
}