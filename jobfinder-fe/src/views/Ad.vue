<template>
  <div>
    <header>
      <h3>{{content}}</h3>
    </header>
  </div>
</template>

<script>
import AdService from '../services/ad-service'

export default {
  name: 'Ad',
  data () {
    return {
      content: ''
    }
  },
  mounted () {
    AdService.getAllAds().then(
      response => {
        console.log(response)
        this.content = response.data
      },
      error => {
        this.content =
        (error.response && error.response.data) ||
          error.message ||
          error.toString()
      }
    )
  }
}
</script>

<style scoped>

</style>
