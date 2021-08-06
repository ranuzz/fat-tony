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

<hr />
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

        <!--
        <b-field label="Rules">
            <b-input maxlength="200" type="textarea" v-model="room_rules"></b-input>
        </b-field>
        -->


        <div class="buttons">
            <b-button type="is-primary" @click="createRoom" expanded>Create Game</b-button>
        </div>

        <b-message title="Gmae Rules" aria-close-label="Close message">
            {{ room_rules }}

<p><strong>Distribution</strong></p>
<ul>
    <li>God x1</li>
    <li>Mafia x2</li>
    <li>Citizens x3</li>
    <li>Detective x1</li>
    <li>Healer x1</li>
    <li>Suicide Bomber x1</li>
</ul>
<br>
<p><strong>About Mafia</strong></p>
<p> Mafia is role playing social deduction game where two groups: an informed minority (mafia), and an uninformed majority (the village) are pitted against each other. The objective for the Mafia (including the mafia and the suicide bomber) is to wipe out the entire village and for the village (including villagers, the detective and the healer) to fish them out. The players are supposed to accomplish this by influencing the conversation and convincing the others. </p>
<br>
<p><strong>Roles and Responsibilities</strong></p>
<ul>
    <li>The God (Moderator) conducts the game but doesn't participate.</li>
    <li>Mafia will kill other players and try to convince other players who the mafia is without revealing themselves.</li>
    <li>The Healer can save any one person including himself/herself.</li>
    <li>The Detective can find out if someone they suspect is the mafia. They use this information to sway public opinion.</li>
    <li>Citizens have the most basic and moral of responsibilities: figure out the mafia and vote them off.</li>
    <li>The Suicide Bomber never reveals himself/herself till he/she decides and when they do they can choose to kill another person along with them. Because of the incentive alignment with the mafia, the suicide bomber usually kills somebody from the village.</li>
</ul>
<br>
<p><strong>Gameplay</strong></p>
<p>Mafia is played in rounds in two separate constructs, night and day.</p>
<p><strong>Night</strong></p>
<p>During the night, when the village is asleep, the god asks the mafia to wake up and decide on whom they want to kill. The mafia collectively decide and let the god know about their decision. The god then wakes up the healer and asks him/her who they want to save. If the mafia chose to kill the healer per their decision, the god intimates the healer that he/she was targeted. The healer can choose to save himself/herself only twice during the entire game. Alternatively if the mafia chose someone else, the healer is asked to pick a person from amongst others who they'd like to save. Post this, the god wakes the detective and asks him/her who they suspect to be the mafia. The detective can point to any person in the group and wait for a confirmation (yes/no) from the god. All this takes some time by which time it is day.</p>
<p><strong>Day</strong></p>
<p>The god wakes up the entire village and let's them know what transpired during the night. The players are then encouraged to participate in discussions to arrive at a consensus of who the mafia is. This is accomplished through voting which the god can call for once he/she feels that adequeate discussions have taken place and opinions are formed. Once the village chooses to vote someone out on the suspicion of them being the mafia, the god pronounces that person as dead. They can no longer participate in the subsequent rounds.</p>
<p>The game ends when either all the mafia have been identified and voted out or it becomes mathematically impossible for the citizens to win.</p>



        </b-message>

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
            room_player_count: 8,
            room_rules: '',
            room_game_type: 'Trivial Mafia',
        };
    },
    methods: {
        snackbar(msg) {
        this.$buefy.snackbar.open(msg);
        },
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
                this.$router.push({ name: 'GodRoom', query: {id: resp.data.roomid}});
            })
            .catch( error => {
                this.snackbar("Error Occured");
                console.log(error);
            });
        },
    },
}
</script>

<style>

</style>
