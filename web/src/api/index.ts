import axios from "axios";

export const Api = {
    async doTp(clientId: string) {
        await axios.get(`/api/clients/${clientId}/tp`)
    },

    async startCast(clientId: string) {
        await axios.get(`/api/clients/${clientId}/skillCast`)
    },
    async stopCast(clientId: string) {
        await axios.get(`/api/clients/${clientId}/skillCast/stop`)
    },

    async move(clientId: string, direction: string){
        await axios.get(`/api/clients/${clientId}/move/${direction}`)
    }
}