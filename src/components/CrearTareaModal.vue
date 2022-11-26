<template>
    <!-- Modal - Register -->
    <div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalLabel"
        aria-hidden="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content container">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Editar cliente</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <form class="row g-4 container-fr">
                        <div class="col-md-12">
                            <label for="id">Id</label>
                            <input v-model="id" type="number" class="form-control" id="id" name="id">
                        </div>
                        <div class="col-md-12">
                            <label for="descripcion">Descripción</label>
                            <input v-model="descripcion" type="text" class="form-control" id="descripcion" name="descripcion">
                        </div>
                        <div class="col-md-12">
                            <label for="estado">Estado</label>
                            <input v-model="estado" type="text" class="form-control" id="estado" name="estado">
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button @click="crearTarea()" RouterLink class="btn btn-primary">Guardar</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import TareasView from '../views/TareasView.vue';

export default {
    data() {
        return {
            titulo: "TuCita.com",
            tareas: [],
            id: 0,
            descripcion: '',
            estado: ''
        };
    },
    methods: {
        async crearTarea() {
            const opciones = {
                method: "POST",
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
    }
}
</script>

<style scoped>
.container-fr {
    padding: 10px 30px 30px 30px;
}
</style>