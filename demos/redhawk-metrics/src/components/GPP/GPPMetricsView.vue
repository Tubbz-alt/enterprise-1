<template>
  <div>
    <chartcard :metricType="metricType"></chartcard>
    <div class="card">
      <div class="card-header" data-background-color="green">
        <h4 class="title">{{ gppName }} </h4>
        <p class="category">Metrics for {{ gppName }}</p>
      </div>
      <div class="card-content">
        <md-input-container>
          <label for="metricType">Metric Type</label>
          <md-select name="metricType" id="metricType" v-model="metricType">
            <md-option
            v-for="(metricType, index) in metricTypes"
            v-bind:key="metricType"
            :value="metricType"
            >
            {{ metricType }}
          </md-option>
        </md-select>
      </md-input-container>
      <gppmetrictable
      :metricType="metricType"
      >
    </gppmetrictable>
  </div>
</div>
</div>
</template>

<script>
import GPPMetricTable from './GPPMetricTable.vue'
import ChartCard from './ChartCard.vue'

export default {
  name: 'gppmetricsview',
  components: {
    'gppmetrictable' : GPPMetricTable,
    'chartcard' : ChartCard
  },
  data() {
    return {
      metricTypes: [
        'utilization',
        'sys_limits',
        //'nic_metrics' TODO: Deal with this
      ],
      metricType: 'utilization'
    }
  },
  mounted(){
    //Get application parameters
    console.log("Route Params")
    var gppName = this.$route.params.gppName

    //Use name to fill out view
    this.$store.dispatch('chooseGPP', gppName)
  },
  computed: {
    gppName(){
      return this.$store.getters.gppName
    },
    metrics(){
      return this.$store.getters.gppMetrics
    },
    url(){
      return this.$store.getters.gppMetricsURL
    }
  },
  methods: {
    /*getAppMetrics(){
      console.log("Made it")
      console.log("URL: "+this.appMetricsURL)
      this.$store.dispatch("setAppMetricsURL", this.appMetricsURL)
      this.$store.dispatch("getAppMetrics", this.appMetricsURL)
    },
    loadInTable(loadMe){
      this.metricType = loadMe
      this.$store.dispatch("getAppMetricsByType", loadMe)

      //TODO: Use set interval
      //this.intervalSetup()
      if(this.interval==null){
        this.interval = setTimeout(this.loadInTable, 1000, this.metricType);
      }else{
        clearTimeout(this.interval)
        this.interval = setTimeout(this.loadInTable, 1000, this.metricType);
      }
    },
    intervalSetup(){
      console.log("HELLO")
      if(this.interval==null){
        self.setInterval(function(){
          console.log("Trying")
          console.log(this)
        }, 1000)
      }else{
        clearInterval(this.interval)
        self.setInterval(function(){
          console.log("Trying")
          console.log(this)
        }, 1000)
      }
    }*/
  }
}
</script>
