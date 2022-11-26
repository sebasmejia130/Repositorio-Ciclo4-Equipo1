import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'Home',
            component: HomeView
        },
        {
            path: '/doctores',
            name: 'doctores',
            component: () => import('../views/DoctoresView.vue')
        },
        {
            path: '/pacientes',
            name: 'pacientes',
            component: () => import('../views/PacientesView.vue')
        },
        {
            path: '/citas',
            name: 'citas',
            component: () => import('../views/CitasView.vue')
        },
        {
            path: '/tareas',
            name: 'tareas',
            component: () => import('../views/TareasView.vue')
        }
    ]
})

export default router;