<script setup lang="ts">
import { useLocalStorage } from "@vueuse/core";
import axios from "axios";
import { ref } from 'vue'

let game = useLocalStorage("game", "current game is unknown")

const makeGame = async () => {
  const res = await axios.get(`/api/ng`)
  game.value = res.data
}

</script>

<template>
  <div class="flex flex-col">
    <div class="flex-1 flex items-center">
      <a href="https://github.com/zygarde-projects/ology-kt" target="_blank">
        <img src="/diablo2-logo-lg.png" class="logo" alt="ology kt" />
      </a>
    </div>
    <div class="flex-1 flex flex-col justify-end">
      <div class="flex flex-col p-4">
        <div class="footer">
          <button class="w-full bg-amber-500 hover:bg-amber-400 text-white font-bold py-4 px-4 rounded" type="button" @click="makeGame">
            {{ game }}
          </button>
        </div>
      </div>
    </div>
  </div>

</template>

<style scoped>
</style>
