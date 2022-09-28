<script setup lang="ts">
// This starter template is using Vue 3 <script setup> SFCs
// Check out https://vuejs.org/api/sfc-script-setup.html#script-setup
import HelloWorld from './components/HelloWorld.vue'
</script>

<template>
  <div class="app">
    <a href="https://github.com/zygarde-projects/ology-kt" target="_blank">
      <img src="/diablo2-logo-lg.png" class="logo" alt="ology kt" />
    </a>
  </div>
  <HelloWorld msg="ology kt" />
</template>

<style scoped>
.logo {
  max-height: 30em;
  padding: 1.5em;
  will-change: filter;
}
.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}
.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}
</style>
