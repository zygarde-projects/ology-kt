<script setup lang="ts">
import { useLocalStorage } from "@vueuse/core";
import axios from "axios";
import { ref } from 'vue'

defineProps<{ msg: string }>()

const ip = useLocalStorage("ip", "localhost")
let game = useLocalStorage("game", "current game is unknown")

const makeGame = async () => {
  const res = await axios.get(`http://${ip.value}:16668/ng`)
  game = res.data
}

</script>

<template>
  <div class="flex flex-col p-4">
    <h4 class="text-center text-white mb-4">{{ ip }}:16668</h4>
    <input
      class="mb-10 block p-4 text-gray-900 bg-gray-50 rounded-lg border border-gray-300 sm:text-md focus:ring-amber-500 focus:border-amber-500 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-amber-500"
      v-model="ip"
    />
    <div class="footer">
      <button class="w-full bg-amber-500 hover:bg-amber-400 text-white font-bold py-4 px-4 rounded" type="button" @click="makeGame">
          {{ game }}
      </button>
    </div>
  </div>
</template>

<style scoped>
</style>
