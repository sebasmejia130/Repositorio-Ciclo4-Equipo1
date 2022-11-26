<template>
    <nav class="navbar navbar-expand-lg">
        <div class="container-fluid">
            <RouterLink to="/" class="navbar-brand">TuCita.com</RouterLink>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <RouterLink to="/doctores" class="nav-link">Doctores</RouterLink>
                    </li>
                    <li class="nav-item">
                        <RouterLink to="/pacientes" class="nav-link">Pacientes</RouterLink>
                    </li>
                    <li class="nav-item">
                        <RouterLink to="/citas" class="nav-link">Citas</RouterLink>
                    </li>
                    <li class="nav-item">
                        <RouterLink to="/tareas" class="nav-link">Tareas</RouterLink>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</template>

<script>
import { RouterLink } from 'vue-router';

export default {
    data() {
        return {

        }
    }
}
</script>

<style scoped>
.navbar {
    background-color: #ada6e7;
    font-weight: 500;
    font-size: medium;
}
</style>