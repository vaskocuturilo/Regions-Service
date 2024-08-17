import {PlateService} from './PlateService';

export class RegularPlateService extends PlateService {
    async getPlatesByRegion(plates) {
        await this.getPlates(`/${plates}/plates/region/${this.getRegionRef.current.value}`);
    }

    async getPlatesByDescription(plates) {
        await this.getPlates(`/${plates}/plates/description/${this.getRegionRef.current.value}`);
    }
}