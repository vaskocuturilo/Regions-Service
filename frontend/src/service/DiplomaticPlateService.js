class DiplomaticPlateService extends PlateService {
    async getPlatesByRegion(diplomatic) {
        await this.getPlates(`/${diplomatic}/diplomatic/plates/region/${this.getRegionRef.current.value}`);
    }

    async getPlatesByDescription(diplomatic) {
        await this.getPlates(`/${diplomatic}/diplomatic/plates/description/${this.getRegionRef.current.value}`);
    }
}