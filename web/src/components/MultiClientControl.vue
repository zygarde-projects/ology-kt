<script setup lang="ts">

import axios from "axios";
import {Client} from "../types/types";
import {computed, onBeforeUnmount, onMounted, ref} from "vue";
import ClientControlCard from "./mcc/ClientControlCard.vue";
import DirectionPad from "./mcc/DirectionPad.vue";

interface SkillLocation {
  x: number,
  y: number
}

let intervalId: number | undefined = undefined
const clients = ref<Client[]>([])
const refreshClients = () => {
  axios.get("/api/clients")
      .then(res => {
        clients.value = res.data
      })
}

onMounted(() => {
  refreshClients()
  intervalId = setInterval(refreshClients, 1000)
})

onBeforeUnmount(() => {
  if (!!intervalId) clearInterval(intervalId)
})

const doNg = async () => {
  await axios.get(`/api/ng`)
}
const doTp = async () => {
  await axios.get(`/api/clients/all/tp`)
}

const dimensionWidth = 3840
const dimensionHeight = 2160
const skillTargetZoneWidth = 594
const skillTargetZoneHeight = 324
const skillLocationDiameter = 50

const skillTargetZoneStyle = {
  width: `${skillTargetZoneWidth}px`,
  height: `${skillTargetZoneHeight}px`,
}

const skillLocation = ref<SkillLocation>({x: 1920, y: 1080})

onMounted(async () => {
  const locationRes = await axios.get<SkillLocation>("/api/skillLocation")
  skillLocation.value = locationRes.data
})

const skillLocationDisplay = computed<SkillLocation>(() => {
  return {
    x: skillLocation.value.x * skillTargetZoneWidth / dimensionWidth - skillLocationDiameter / 2,
    y: skillLocation.value.y * skillTargetZoneHeight / dimensionHeight - skillLocationDiameter / 2
  }
})

const getSkillLocationStyle = computed(() => {
  return {
    left: `${skillLocationDisplay.value.x}px`,
    top: `${skillLocationDisplay.value.y}px`,
  }
})

const handleSkillLocationChange = async (e: MouseEvent) => {
  let x = e.offsetX * dimensionWidth / skillTargetZoneWidth;
  let y = e.offsetY * dimensionHeight / skillTargetZoneHeight;
  skillLocation.value = {
    x,
    y,
  }

  await axios.get(`/api/clients/all/skillCast/location?x=${x.toFixed(0)}&y=${y.toFixed(0)}`)
}

</script>
<template>
  <div class="flex flex-col">
    <div class="flex p-4">
      <div class="w-24">
        <div class="flex">
          <button class="bg-blue-700 text-white action-btn" @click="doNg">NG</button>
        </div>
        <div class="flex">
          <button class="bg-red-700 text-white action-btn" @click="doTp">TP</button>
        </div>
      </div>
      <div class="flex-1">

      </div>
      <div class="w-48 p-4">
        <direction-pad :can-move="true" client="all"/>
      </div>
      <div id="skill-target-zone"
           @click="handleSkillLocationChange($event)"
           :style="skillTargetZoneStyle">
        <div id="skill-location" :style="getSkillLocationStyle"></div>
      </div>
    </div>
    <div class="flex flex-wrap">
      <client-control-card v-for="c in clients" :key="c.id" :client="c"/>
    </div>
  </div>


</template>
<style scoped>
.action-btn {
  @apply flex-1 m-2 py-2 text-center text-lg leading-tight uppercase rounded shadow-md hover:bg-gray-300 hover:shadow-lg focus:bg-gray-300 focus:shadow-lg focus:outline-none focus:ring-0 active:bg-gray-400 active:shadow-lg transition duration-150 ease-in-out
}

#skill-target-zone {
  background: url("/game.png");
  background-size: cover;
  background-repeat: no-repeat;
  background-position: center center;
}

#skill-location {
  position: relative;
  width: 50px;
  height: 50px;
  @apply rounded-full bg-lime-200 opacity-50
}
</style>
