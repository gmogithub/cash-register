import {Http} from '../utils/Http'

export class RightRepository {

    newRight() {
        return {
            id: 0,
            code: '',
            name: '',
            description: '',
            api: ''
        };
    }

    async getRights() {
        return await Http.get('admin/rights');
    }

    async getRight(id) {
        return await Http.get('admin/rights/' + id);
    }

    async save(right) {
        return await Http.post('admin/rights', right);
    }

    async update(right) {
        return await Http.put('admin/rights', right);
    }

    async delete(id) {
        return await Http.delete('admin/rights/' + id);
    }
}