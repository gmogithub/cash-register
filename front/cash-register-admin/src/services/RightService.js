import {RightRepository} from "../repositories/RightRepository";

const rightRepository = new RightRepository();

export class RightService {

    newRigth () {
        return rightRepository.newRight();
    }

    async getRights () {
        return await rightRepository.getRights();
    }

    async getRight (id) {
        return await rightRepository.getRight(id);
    }

    async save (right) {
        return await rightRepository.save(right);
    }

    async update (right) {
        return await rightRepository.update(right);
    }

    async delete (id) {
        return await rightRepository.delete(id);
    }

}