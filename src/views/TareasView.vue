<template>
    <section class="container-fluid">
        <div class="card-header-flex">
            <h3>Tareas</h3>
            <button class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#registerModal">Insertar</button>
        </div>
        <div class="car-body">
            <table class="table table-hover">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>DESCRIPCION</th>
                        <th>ESTADO</th>
                        <th>ACCIONES</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="tarea in tareas">
                        <td>{{ tarea.id }}</td>
                        <td>{{ tarea.descripcion }}</td>
                        <td>{{ tarea.estado }}</td>
                        <td>
                            <div class="buttons-acciones">
                                <button type="button" class="btn btn-warning" data-bs-toggle="modal"
                                    data-bs-target="#editarModal">
                                    <img src="../assets/svg/edit.svg" alt="">
                                </button>
                                <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                    data-bs-target="#eliminarModal">
                                    <img src="../assets/svg/delete.svg" alt="">
                                </button>
                            </div>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>
    </section>
    <CrearTareaModal/>
</template>

<script>
import CrearTareaModal from '../components/CrearTareaModal.vue';

export default {
    data() {
        return {
            titulo: "TuCita.com",
            tareas: []
        };
    },
    methods: {
        async consultaTareas() {
            const opciones = {
                method: "GET",
                headers: {
                    "Content-Type": "application/json",
                    "Cache-Control": "no-cache",
                    "Authorization": "Basic dXNlcjo5ZTJjOTkxZi1iNzk5LTRkMzgtYmJkOC00ZGEyOTk3ZWU1NGM="
                }
            };
            fetch("http://localhost:8080/api/tareas", opciones)
                .then(async (response) => {
                    if (!response.ok) {
                        const error = new Error(response.statusText);
                        error.json = response.json();
                        console.log(error.message);
                        throw error;
                    }
                    else {
                        this.tareas = await response.json();
                        console.log(this.tareas);
                        console.log(this.tareas.length);
                        console.log(this.tareas[0].descripcion);
                    }
                });
        },
        async crearTarea() {
            const opciones = {
                method: "PUT",
                headers: {
                    "Content-Type": "application/json",
                    "Cache-Control": "no-cache",
                    "Authorization": "Basic dXNlcjo5ZTJjOTkxZi1iNzk5LTRkMzgtYmJkOC00ZGEyOTk3ZWU1NGM="
                },
                body: JSON.stringify({
                    id: this.id,
                    descripcion: this.descripcion,
                    estado: this.estado
                })
            };
            fetch("http://localhost:8080/api/tareas", opciones)
                .then(async (response) => {
                    if (!response.ok) {
                        const error = new Error(response.statusText);
                        error.json = response.json();
                        throw error;
                    }
                    else {
                        const data = await response.json();
                        console.log(data);
                        TareasView.consultaTareas();
                    }
                });
        }
    },
    beforeMount() {
        this.consultaTareas();
    },
    components: { CrearTareaModal }
}
</script>

<style scoped>
.buttons-acciones {
    display: grid;
    grid-template-columns: 1fr 1fr;
    gap: 5px;
}

.buttons-acciones button {
    display: flex;
    justify-content: center;
    align-items: center;
}

.card-header-flex {
    margin: 10px 50px;
    display: grid;
    grid-template-columns: 70% 30%;
}

.car-body {
    margin: 20px 100px;
}

.container-fluid {
    margin: 0;
    padding: 0;
    width: 95%;
}

.row {
    margin: 0;
    padding: 0;
}

#editarModal {
    display: flexbox;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}
</style>