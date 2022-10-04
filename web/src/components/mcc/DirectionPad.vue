<script setup lang="ts">
import axios from "axios";

const props = defineProps<{client:string, canMove: boolean}>()

const doMove = async (direction: string) => {
  await axios.get(`/api/clients/${props.client}/move/${direction}`)
}

</script>

<template>
  <div>
    <div class="flex flex-col">
      <div class="flex">
        <button :disabled="!canMove" class="arrow-btn" @click="doMove('UP_LEFT')">
          <img src="/arrow/north_west_black_24dp.svg"/>
        </button>
        <button :disabled="!canMove" class="arrow-btn" @click="doMove('UP')">
          <img src="/arrow/north_black_24dp.svg"/>
        </button>
        <button :disabled="!canMove" class="arrow-btn" @click="doMove('UP_RIGHT')">
          <img src="/arrow/north_east_black_24dp.svg"/>
        </button>
      </div>
      <div class="flex">
        <button :disabled="!canMove" class="arrow-btn" @click="doMove('LEFT')">
          <img src="/arrow/west_black_24dp.svg"/>
        </button>
        <div class=" flex-1 m-1 p-2"></div>
        <button :disabled="!canMove" class="arrow-btn" @click="doMove('RIGHT')">
          <img src="/arrow/east_black_24dp.svg"/>
        </button>
      </div>
      <div class="flex">
        <button :disabled="!canMove" class="arrow-btn" @click="doMove('DOWN_LEFT')">
          <img src="/arrow/south_west_black_24dp.svg"/>
        </button>
        <button :disabled="!canMove" class="arrow-btn" @click="doMove('DOWN')">
          <img src="/arrow/south_black_24dp.svg"/>
        </button>
        <button :disabled="!canMove" class="arrow-btn" @click="doMove('DOWN_RIGHT')">
          <img src="/arrow/south_east_black_24dp.svg"/>
        </button>
      </div>
    </div>
  </div>
</template>

<style scoped>
.arrow-btn {
  @apply flex items-center justify-center flex-1 m-1 p-2 text-center bg-gray-300 font-medium text-xs leading-tight uppercase rounded shadow-md hover:bg-gray-300 hover:shadow-lg focus:bg-gray-300 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-gray-400 active:shadow-lg transition duration-150 ease-in-out
}

</style>