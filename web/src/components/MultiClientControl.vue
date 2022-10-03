<script setup lang="ts">

import axios from "axios";
import {Client} from "../types/types";
import {onBeforeUnmount, onMounted, ref} from "vue";
import ClientControlCard from "./mcc/ClientControlCard.vue";

let intervalId: number | undefined = undefined
const clients = ref<Client[]>([])
const refreshClients = () => {
  axios.get("/api/clients")
      .then(res => {
        clients.value = res.data
      })
}

onMounted(() => {
  refreshClients()
  intervalId = setInterval(refreshClients, 1000)
})

onBeforeUnmount(() => {
  if (!!intervalId) clearInterval(intervalId)
})

const doNg = async () => {
  await axios.get(`/api/ng`)
}
const doTp = async () => {
  await axios.get(`/api/clients/all/tp`)
}

</script>
<template>
  <div class="flex p-4">
    <button class="bg-blue-700 text-white action-btn" @click="doNg">NG</button>
    <button class="bg-red-700 text-white action-btn" @click="doTp">TP</button>
  </div>
  <div class="flex flex-wrap">
    <client-control-card v-for="c in clients" :key="c.id" :client="c"/>
  </div>

</template>
<style scoped>
.action-btn {
  @apply flex-1 mx-4 py-4 text-center text-lg leading-tight uppercase rounded shadow-md hover:bg-gray-300 hover:shadow-lg focus:bg-gray-300 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-gray-400 active:shadow-lg transition duration-150 ease-in-out
}
</style>
