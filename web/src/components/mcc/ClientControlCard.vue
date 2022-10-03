<script setup lang="ts">
import {Client} from "../../types/types";
import {computed} from "vue";
import {formatDuration, formatISODuration, intervalToDuration} from "date-fns";
import axios from "axios";

const props = defineProps<{ client: Client }>()

const shortEnLocale = {formatDistance: (token: string, count: number) => count + token.substring(1, 2).toLowerCase()}

const connectTime = computed(() => {
  return formatDuration(
      intervalToDuration({start: new Date(props.client.connectAt), end: new Date()}),
      {format: ['minutes', 'seconds'], locale: shortEnLocale}
  )
})

const doMove = async (direction: string) => {
  await axios.get(`/api/clients/${props.client.id}/move/${direction}`)
}

const doTp = async () => {
  await axios.get(`/api/clients/${props.client.id}/tp`)
}

</script>
<template>
  <div class="flex justify-center my-2" style="width: 50vw">
    <div class="flex justify-center w-full">
      <div class="flex flex-col md:flex-row md:max-w-xl rounded-lg bg-white shadow-lg">
        <div class="p-2 flex flex-col justify-start">
          <div class="flex">
            <div class="flex-1 text-l text-blue-500">{{ client.name }}</div>
            <div class="text-gray-600 text-xs text-right">{{ connectTime }}</div>
          </div>
          <div>
            <div class="flex flex-col">
              <div class="flex">
                <button :disabled="!client.inGame" class="arrow-btn" @click="doMove('UP_LEFT')">
                  <img src="/arrow/north_west_black_24dp.svg"/>
                </button>
                <button :disabled="!client.inGame" class="arrow-btn" @click="doMove('UP')">
                  <img src="/arrow/north_black_24dp.svg"/>
                </button>
                <button :disabled="!client.inGame" class="arrow-btn" @click="doMove('UP_RIGHT')">
                  <img src="/arrow/north_east_black_24dp.svg"/>
                </button>
              </div>
              <div class="flex">
                <button :disabled="!client.inGame" class="arrow-btn" @click="doMove('LEFT')">
                  <img src="/arrow/west_black_24dp.svg"/>
                </button>
                <div class=" flex-1 m-2"></div>
                <button :disabled="!client.inGame" class="arrow-btn" @click="doMove('RIGHT')">
                  <img src="/arrow/east_black_24dp.svg"/>
                </button>
              </div>
              <div class="flex">
                <button :disabled="!client.inGame" class="arrow-btn" @click="doMove('DOWN_LEFT')">
                  <img src="/arrow/south_west_black_24dp.svg"/>
                </button>
                <button :disabled="!client.inGame" class="arrow-btn" @click="doMove('DOWN')">
                  <img src="/arrow/south_black_24dp.svg"/>
                </button>
                <button :disabled="!client.inGame" class="arrow-btn" @click="doMove('DOWN_RIGHT')">
                  <img src="/arrow/south_east_black_24dp.svg"/>
                </button>
              </div>
            </div>
          </div>
          <div class="flex mt-2">
            <button :disabled="!client.inGame" class="bg-blue-700 text-white action-btn" @click="doTp">TP</button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
.arrow-btn {
  @apply flex-1 m-1 p-2 text-center bg-gray-300 font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-gray-300 hover:shadow-lg focus:bg-gray-300 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-gray-400 active:shadow-lg transition duration-150 ease-in-out
}

.action-btn {
  @apply flex-1 m-1 p-2 text-center text-xs leading-tight uppercase rounded shadow-md hover:bg-gray-300 hover:shadow-lg focus:bg-gray-300 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-gray-400 active:shadow-lg transition duration-150 ease-in-out
}

button:disabled {
  @apply bg-gray-500 opacity-50 transition-none active:bg-gray-500 focus:bg-gray-500 hover:bg-gray-500
}
</style>
