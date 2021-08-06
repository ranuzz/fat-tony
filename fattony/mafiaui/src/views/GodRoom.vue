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
    <section>
      <div class="columns">
        <div class="column is-1"></div>
        <div class="column is-8">

            <div class="tile is-ancestor">
                  <div v-for="item in row_one" :key="item.id">
                    <div class="tile is-parent">
                      <article class="tile is-child box">
                        <p v-if="players.length < item.id" class="title">Waiting for : {{item.id}}</p>
                        <div v-if="players.length >= item.id">
                          <p class="title">{{players[item.id-1].name}}</p><br />
                          <b-tag type="is-info">Dead:{{players[item.id-1].dead}}</b-tag><br />
                          <b-tag type="is-info">Role:{{players[item.id-1].role}}</b-tag><br />
                          <b-tag type="is-info">Vote:{{players[item.id-1].vote}}</b-tag><br />
                          <b-tag type="is-info">Eye:{{players[item.id-1].sight}}</b-tag><br />
                        </div>
                      </article>
                    </div>
                  </div>
            </div>

            <div class="tile is-ancestor">
                  <div v-for="item in row_two" :key="item.id">
                    <div class="tile is-parent">
                      <article class="tile is-child box">
                        <p v-if="players.length < item.id" class="title">Waiting for : {{item.id}}</p>
                        <div v-if="players.length >= item.id">
                          <p class="title">{{players[item.id-1].name}}</p><br />
                          <b-tag type="is-info">Dead:{{players[item.id-1].dead}}</b-tag><br />
                          <b-tag type="is-info">Role:{{players[item.id-1].role}}</b-tag><br />
                          <b-tag type="is-info">Vote:{{players[item.id-1].vote}}</b-tag><br />
                          <b-tag type="is-info">Eye:{{players[item.id-1].sight}}</b-tag><br />
                        </div>
                      </article>
                    </div>
                  </div>
            </div>
            <!--
            <div class="tile is-ancestor">
              <div class="tile is-parent">
                <article class="tile is-child box">
                  <p class="title">Six</p>
                  <p class="subtitle">Stats</p>
                </article>
              </div>
              <div class="tile is-parent">
                <article class="tile is-child box">
                  <p class="title">Seven</p>
                  <p class="subtitle">Stats</p>
                </article>
              </div>
              <div class="tile is-parent">
                <article class="tile is-child box">
                  <p class="title">Eight</p>
                  <p class="subtitle">Stats</p>
                </article>
              </div>
              <div class="tile is-parent">
                <article class="tile is-child box">
                  <p class="title">Nine</p>
                  <p class="subtitle">Stats</p>
                </article>
              </div>
            </div>

            <div class="tile is-ancestor">
              <div class="tile is-parent">
                <article class="tile is-child box">
                  <p class="title">Six</p>
                  <p class="subtitle">Stats</p>
                </article>
              </div>
              <div class="tile is-parent">
                <article class="tile is-child box">
                  <p class="title">Seven</p>
                  <p class="subtitle">Stats</p>
                </article>
              </div>
              <div class="tile is-parent">
                <article class="tile is-child box">
                  <p class="title">Eight</p>
                  <p class="subtitle">Stats</p>
                </article>
              </div>
              <div class="tile is-parent">
                <article class="tile is-child box">
                  <p class="title">Nine</p>
                  <p class="subtitle">Stats</p>
                </article>
              </div>
            </div>
            -->

        </div>
        <div class="column is-2">
                  <b-collapse class="card" animation="slide" aria-id="contentIdForA11y3">
            <div
                slot="trigger" 
                slot-scope="props"
                class="card-header"
                role="button"
                aria-controls="contentIdForA11y3">
                <p class="card-header-title">
                   Game &nbsp; <b>{{room_key}}</b>
                </p>
                <a class="card-header-icon">
                    <b-icon
                        :icon="props.open ? 'menu-down' : 'menu-up'">
                    </b-icon>
                </a>
            </div>
            <div class="card-content">
                <div class="content">
                  <ul>
                    <li>Key: {{room_key}}</li>
                    <li>Name: {{room_name}}</li>
                    <li>Players: {{room_player_count}}</li>
                    <li>Type: {{room_game_type}}</li>
                    <li>Rules: {{room_rules}}</li>
                  </ul>
                </div>
            </div>
        </b-collapse>
        </div>
        <div class="column is-1"></div>
      </div>
    </section>

  <hr />
    <section>
      <div class="columns">
        <div class="column is-1"></div>
        <div class="column is-3">
          <div class="buttons has-addons">
            <button class="button">Next</button>
            <button class="button">End Round</button>
            <button class="button">Restart</button>
          </div>
        </div>
        <div class="column is-4">
          <div class="buttons has-addons">
            <button class="button">Call to wake-up</button>
            <button class="button">Call for vote</button>
            <button class="button">Call for what ?</button>
          </div>          
        </div>
        <div class="column is-3">
          <div class="buttons has-addons">
            <button class="button">Refresh</button>
            <button class="button">Pull Stats</button>
            <button class="button">Pause</button>
          </div>
        </div>
        <div class="column is-1"></div>
      </div>
    </section>

 </div> 
</template>

<script>
export default {
  name: 'GodRoom',
  data() {
    return {
      roomid: -1,
      room_name: '',
      room_player_count: 0,
      room_rules: '',
      room_game_type: '',
      room_key: '',
      players: [],
      row_one: [
        {id: 1},
        {id: 2},
        {id: 3},
        {id: 4},
      ],
      row_two: [
        {id: 5},
        {id: 6},
        {id: 7},
        {id: 8},
      ]
    };
  },
  methods: {
    snackbar(msg) {
      this.$buefy.snackbar.open(msg);
    },
    getRoomPlayer() {
        setTimeout(() => this.getRoomPlayer(), 1000);
        if (this.room_id === -1) {
            return;
        }
        this.$http.get("/api/player/room/"+this.roomid)
            .then(resp => {
                this.players = resp.data;
                console.log(resp);
                //this.snackbar("Current Joined players : "+ this.players.length);
            })
            .catch(error => {
                console.log(error);
            })
    },
    getRoomDetails(rid) {
        this.$http.get('/api/room/'+rid)
            .then( resp => {
                console.log(resp);
                this.snackbar("Fresh Game : " + resp.data.name);
                this.roomid = resp.data.roomid;
                this.room_name = resp.data.name;
                this.room_player_count = resp.data.numplayers;
                this.room_rules = resp.data.rules;
                this.room_game_type = resp.data.gametype
                this.room_key = resp.data.roomkey;
            })
            .catch( error => {
                this.snackbar("Error in game creation");
                console.log(error);
            });
    },
  },
  mounted() {
    console.log(this.$route.query);
    this.roomid = this.$route.query['id'];
    this.getRoomDetails(this.roomid);
    this.getRoomPlayer();
  }
}
</script>

<style>

</style>