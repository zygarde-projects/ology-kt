<script setup lang="ts">
import axios from "axios";
import { ref } from 'vue'

defineProps<{ msg: string }>()

const ip = ref("localhost")

const makeGame = async () => {
    await axios.get("http://localhost:16668/ng")
}

</script>

<template>
  <h1>{{ ip }}:16668</h1>

    <input v-model="ip"/>

  <div class="card">
    <button type="button" @click="makeGame">current game is foo</button>
  </div>
</template>

<style scoped>
</style>
