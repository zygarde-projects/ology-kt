<script setup lang="ts">
// This starter template is using Vue 3 <script setup> SFCs
// Check out https://vuejs.org/api/sfc-script-setup.html#script-setup
import MakeGame from './components/MakeGame.vue'
</script>

<template>
  <div class="app flex justify-center">
      <div class="flex flex-col">
          <div class="flex-1 flex items-center max-w-screen-lg">
              <a href="https://github.com/zygarde-projects/ology-kt" target="_blank">
                  <img src="/diablo2-logo-lg.png" class="logo" alt="ology kt" />
              </a>
          </div>
          <div class="flex-1 flex flex-col justify-end">
              <MakeGame msg="ology kt" />
          </div>
      </div>
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
