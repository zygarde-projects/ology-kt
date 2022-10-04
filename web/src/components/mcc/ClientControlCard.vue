<script setup lang="ts">
import {Client} from "../../types/types";
import {computed} from "vue";
import {formatDuration, intervalToDuration} from "date-fns";
import axios from "axios";
import DirectionPad from "./DirectionPad.vue";

const props = defineProps<{ client: Client }>()

const shortEnLocale = {formatDistance: (token: string, count: number) => count + token.substring(1, 2).toLowerCase()}

const connectTime = computed(() => {
  return formatDuration(
      intervalToDuration({start: new Date(props.client.connectAt), end: new Date()}),
      {format: ['minutes', 'seconds'], locale: shortEnLocale}
  )
})


const doTp = async () => {
  await axios.get(`/api/clients/${props.client.id}/tp`)
}

const startCast = async () => {
  await axios.get(`/api/clients/${props.client.id}/skillCast`)
}
const stopCast = async () => {
  await axios.get(`/api/clients/${props.client.id}/skillCast/stop`)
}

</script>
<template>
  <div class="flex justify-center m-4">
    <div class="flex justify-center w-full">
      <div class="flex flex-col md:flex-row md:max-w-xl rounded-lg bg-white shadow-lg">
        <div class="p-2 flex flex-col justify-start">
          <div class="flex">
            <div class="flex-1 text-l text-blue-500">{{ client.name }}</div>
            <div class="text-gray-600 text-xs text-right">{{ connectTime }}</div>
          </div>
          <direction-pad :can-move="client.inGame" :client="client.name" />
          <div class="flex mt-2">
            <button :disabled="!client.inGame" class="bg-blue-700 text-white action-btn" @click="doTp">TP</button>
          </div>
          <hr/>
          <div class="flex mt-2 flex-col">
            <h4>Cast</h4>
            <button :disabled="!client.inGame" class="bg-green-700 text-white action-btn" @click="startCast">Cast</button>
            <button :disabled="!client.inGame" class="bg-gray-400 text-white action-btn" @click="stopCast">Stop</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>

.action-btn {
  @apply flex-1 m-1 p-2 text-center text-xs leading-tight uppercase rounded shadow-md hover:bg-gray-300 hover:shadow-lg focus:bg-gray-300 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-gray-400 active:shadow-lg transition duration-150 ease-in-out
}

button:disabled {
  @apply bg-gray-500 opacity-50 transition-none active:bg-gray-500 focus:bg-gray-500 hover:bg-gray-500
}
</style>
