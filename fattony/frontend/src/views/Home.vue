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
            <b-navbar-item href="#">
                Create Room
            </b-navbar-item>
            <b-navbar-item href="#">
                Join Room
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
                        <strong>Sign up</strong>
                    </a>
                    <a class="button is-light">
                        Log in
                    </a>
                </div>
            </b-navbar-item>
        </template>
    </b-navbar>

    <section class="section">
    <div class="columns">
    <div class="column is-5"></div>
    <div class="column is-3">
    <section class="hero">
      <div class="hero-body">
        <div class="container">
          <h1 class="title">
            Fat Tony
          </h1>
          <h2 class="subtitle">
            Social Mafia Game !
          </h2>
        </div>
      </div>
    </section>
    </div>
    <div class="column is-4"></div>
    </div>
    </section>

    <section class="section">
      <div class="columns">
        <div class="column"></div>
        <div class="column">
        <div class="buttons">
            <b-button type="is-primary" @click="creatRoom" expanded>Create Room</b-button>
        </div>
        <b-field label="Or find a Room key and Join room"
            type="is-success"
            message="">
            <b-input v-model="roomkey" maxlength="300"></b-input>
        </b-field>
        <b-field label="with a unique name"
            type="is-success">
            <b-input v-model="playername" maxlength="300"></b-input>
        </b-field>
        <div class="buttons">
            <b-button type="is-primary" @click="joinRoom" expanded>Join Room</b-button>
        </div>        
        </div>
        <div class="column"></div>
      </div>
    </section>

    </div>
</template>

<script>

export default {
  name: 'Home',
  data() {
    return {
      error: null,
      roomkey: 'key',
      playername: 'player',
      playerid: 0,
    };
  },
  methods: {
    creatRoom() {
      console.log('creating room');
      this.$router.push({ name: 'CreateRoom' });
    },
    snackbar(msg) {
      this.$buefy.snackbar.open(msg);
    },
    createPlayer(room_id) {
      const request = {
        name: this.playername,
        roomkey: this.roomkey,
        roomid: room_id
      }
      this.$http.post("/api/player/create", request)
        .then(resp => {
          let pid = resp.data.playerid;
          this.$router.push({ name: 'PlayerRoom', params: { id: pid} });
        })
        .catch(error => {
          console.log(error);
          this.snackbar(error);
        })

    },
    getRoomByKey() {
      this.$http.get("/api/room/key/"+this.roomkey)
        .then(resp => {
          if (resp.data.roomid === -1) {
            this.snackbar("Game not found");
          } else {
            this.createPlayer(resp.data.roomid);
          }
        })
        .catch(error => {
          console.log(error);
          this.snackbar(error);
        });
    },
    joinRoom() {
      console.log("joining Game");
      this.snackbar("Joining Game");
      this.getRoomByKey();
    }
  },
};
</script>
