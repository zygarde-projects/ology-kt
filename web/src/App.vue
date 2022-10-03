<script setup lang="ts">
// This starter template is using Vue 3 <script setup> SFCs
// Check out https://vuejs.org/api/sfc-script-setup.html#script-setup
import MultiClientControl from "./components/MultiClientControl.vue";
import SimpleMode from "./components/SimpleMode.vue";

const mcc = window.location.search.includes("mcc")
</script>

<template>
  <div class="app">
    <multi-client-control v-if="mcc"/>
    <simple-mode v-else/>
  </div>
</template>

<style scoped>
.app {
    min-width: 100vw;
    min-height: 100vh;
}
.logo {
  max-width: 100%;
  will-change: filter;
}
.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}
.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}
</style>
