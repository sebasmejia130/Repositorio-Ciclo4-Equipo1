<template>
    <div id="app">
        <Header/>
        <div class="row">
            <RouterView/>
        </div>
        <Footer/>
    </div>
</template>

<script>
import { RouterView } from 'vue-router';
import Header from './components/Header.vue';
import Footer from './components/Footer.vue';


export default {
    name: 'App',
    components: {
    Header,
    Footer
},
    data() {
        return { titulo: 'TuCita.com' }
    }
}
</script>

<style scoped>
    .row {
    margin: 0;
    padding: 0;
}
</style>