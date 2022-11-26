<template>
    <!-- Modal -->
    <div class="modal fade" id="eliminarModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Eliminar paciente</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    Esta seguro de eliminar el paciente {{paciente.id}}
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                    <button @click="eliminarPaciente(paciente.id)" type="button" class="btn btn-danger">Eliminar</button>
                </div>
            </div>
        </div>
    </div>
    <!-- End Modal -->
</template>

<script>

export default {
    props: {
        paciente: {
            type: Object
        }
    },
    data() {
        return {

        }
    },
    methods: {
        async eliminarPaciente() {
            const opciones = {
                method: "DELETE",
                headers: {
                    "Content-Type": "application/json",
                    "Cache-Control": "no-cache",
                    "Authorization": "Basic dXNlcjpkZTAzMDgyNy0yZTI5LTQxMGUtYTgxNi0zMzUzMjlhNWU5YzI="
                }
            };
            fetch(`http://localhost:8080/api/pacientes/d/${this.paciente.id}`, opciones)
                .then(async (response) => {
                    if (!response.ok) {
                        const error = new Error(response.statusText);
                        error.json = response.json();
                        throw error;
                    }
                    else {
                        const data = await response.json();
                        console.log(data);
                    }
                });
        }
    }
}
</script>

<style>

</style>