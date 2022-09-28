import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import mobile from 'vite-plugin-mobile'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  base: '/ology-kt/'
})
