<template>
    <!-- Modal - Register -->
    <div class="modal fade" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="registerModalLabel"
        aria-hidden="true">
        <div class="modal-dialog modal-lg modal-dialog-centered">
            <div class="modal-content container">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Editar cita</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close">
                    </button>
                </div>
                <div class="modal-body">
                    <form class="row g-4 container-fr">
                        <div class="col-md-6">
                            <label for="id">Id</label>
                            <input v-model="id" type="number" class="form-control" id="id" name="id">
                        </div>
                        <div class="col-md-6">
                            <label for="nombres">Tipo</label>
                            <input v-model="tipoExamen" type="text" class="form-control" id="tipoExamen"
                                name="tipoExamen">
                        </div>
                        <div class="col-md-6">
                            <label for="primerApellido">Centro medico</label>
                            <input v-model="lugarProcedimiento" type="text" class="form-control"
                                id="lugarProcedimiento" name="lugarProcedimiento">
                        </div>
                        <div class="col-md-6">
                            <label for="segundoApellido">Fecha</label>
                            <input v-model="fechaProcedimiento" type="date" class="form-control"
                                id="fechaProcedimiento" name="fechaProcedimiento">
                        </div>
                        <div class="col-md-6">
                            <label for="telefono">Paciente</label>
                            <input v-model="paciente" type="text" class="form-control" id="tepacientelefono"
                                name="paciente">
                        </div>
                        <div class="col-md-6">
                            <label for="correo">Id Medico</label>
                            <input v-model="idMedicoGeneral" type="number" class="form-control" id="idMedicoGeneral"
                                name="idMedicoGeneral">
                        </div>
                    </form>
                    <div class="modal-footer">
                        <button @click="crearCita" class="btn btn-primary">Guardar</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>

export default {

    data() {
        return {
            titulo: "TuCita.com",
            citas: [],
            id: null,
            tipoExamen: '',
            lugarProcedimiento: '',
            fechaProcedimiento: '',
            paciente: '',
            idMedicoGeneral: null
        };
    },
    methods: {
        limpiarForm() {
            this.id = null,
            this.tipoExamen = '',
            this.lugarProcedimiento = '',
            this.fechaProcedimiento = '',
            this.paciente = '',
            this.idMedicoGeneral = null
        },
        async crearCita() {
            const opciones = {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                    "Cache-Control": "no-cache",
                    "Authorization": "Basic dXNlcjpkMWQ2NjA3MS1jZTljLTQ5YjktOTJhNy0xM2E1MjUzNDQwMTY="
                },
                body: JSON.stringify({
                    id: this.id,
                    lugarProcedimiento: this.lugarProcedimiento,
                    tipoExamen: this.tipoExamen,
                    fechaProcedimiento: this.fechaProcedimiento,
                    paciente: this.paciente,
                    idMedicoGeneral: this.idMedicoGeneral,
                })
            };
            fetch("http://localhost:8080/api/ordenes", opciones)
                .then(async (response) => {
                    if (!response.ok) {
                        const error = new Error(response.statusText);
                        error.json = response.json();
                        throw error;
                    }
                    else {
                        const data = await response.json();
                        console.log(data);
                        this.limpiarForm();
                        this.$emit('cita-creada');
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