<script setup lang="ts">
import axios from "axios";
import { ref } from 'vue'

defineProps<{ msg: string }>()

const ip = ref("localhost")
let game = ref("unknown")

const makeGame = async () => {
    const res = await axios.get("http://localhost:16668/ng")
    game = res.data
}

</script>

<template>
  <h1>{{ ip }}:16668</h1>

    <input v-model="ip"/>

  <div class="card">
    <button type="button" @click="makeGame">current game is {{ game }}</button>
  </div>
</template>

<style scoped>
input, button {
    font-size: 1.2em;
    line-height: 3em;
    border-radius: 1em;
}
</style>
