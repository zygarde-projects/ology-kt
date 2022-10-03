import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue()],
  base: '/web/',
  server:{
    host: '0.0.0.0',
    proxy: {
      '/api': {
        target: 'http://localhost:16668',
        changeOrigin: true,
      },
    }
  }
})
