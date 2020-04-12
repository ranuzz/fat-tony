<template>
 <div>
    <b-navbar>
        <template slot="brand">
            <b-navbar-item tag="router-link" :to="{ path: '/' }">
                <img
                    src="../assets/logo.png"
                    alt="fat tony mafia game"
                >
            </b-navbar-item>
        </template>
        <template slot="start">
            <b-navbar-item href="#">
                Home
            </b-navbar-item>
            <b-navbar-dropdown label="Info">
                <b-navbar-item href="#">
                    Rules
                </b-navbar-item>
                <b-navbar-item href="#">
                    Contact
                </b-navbar-item>
            </b-navbar-dropdown>
        </template>

        <template slot="end">
            <b-navbar-item tag="div">
                <div class="buttons">
                    <a class="button is-primary">
                        <strong>End Game</strong>
                    </a>
                </div>
            </b-navbar-item>
        </template>
    </b-navbar>

    <div class="columns">
        <div class="column"></div>
        <div class="column is-half">
    <section>
        <b-field label="Room Name">
            <b-input v-model="room_name"></b-input>
        </b-field>

        <b-field label="Num Players">
            <b-input v-model="room_player_count"></b-input>
        </b-field>

        <b-field label="Game Type">
            <b-input v-model="room_game_type"></b-input>
        </b-field>

        <b-field label="Rules">
            <b-input maxlength="200" type="textarea" v-model="room_rules"></b-input>
        </b-field>
        <div class="buttons">
            <b-button type="is-primary" @click="createRoom" expanded>Create Game</b-button>
        </div>
    </section>
        </div>
        <div class="column"></div>
    </div>

 </div>
</template>

<script>
export default {
    name: 'createroom',
    data() {
        return {
            room_name: '',
            room_player_count: 0,
            room_rules: '',
            room_game_type: '',
        };
    },
    methods: {
        createRoom() {
        const roomrequest = {
            name: this.room_name,
            gametype: this.room_game_type,
            numplayers: this.room_player_count,
            rules: this.room_rules,
        }
        this.$http.post('/api/room/create', roomrequest)
            .then( resp => {
                console.log(resp);
            })
            .catch( error => {
                console.log(error);
            });
        },
    },
}
</script>

<style>

</style>
