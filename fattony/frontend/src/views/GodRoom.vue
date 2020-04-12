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
              <div class="tile is-parent">
                <article class="tile is-child box">
                  <p class="title">One</p>
                  <p class="subtitle">Stats</p>
                </article>
              </div>
              <div class="tile is-parent">
                <article class="tile is-child box">
                  <p class="title">Two</p>
                  <p class="subtitle">Stats</p>
                </article>
              </div>
              <div class="tile is-parent">
                <article class="tile is-child box">
                  <p class="title">Three</p>
                  <p class="subtitle">Stats</p>
                </article>
              </div>
              <div class="tile is-parent">
                <article class="tile is-child box">
                  <p class="title">Four</p>
                  <p class="subtitle">Stats</p>
                </article>
              </div>
              <div class="tile is-parent">
                <article class="tile is-child box">
                  <p class="title">Five</p>
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
              <div class="tile is-parent">
                <article class="tile is-child box">
                  <p class="title">Ten</p>
                  <p class="subtitle">Stats</p>
                </article>
              </div>
            </div>


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
                   Game Details
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
      roomid: 'unknown',
      room_name: '',
      room_player_count: 0,
      room_rules: '',
      room_game_type: '',
    };
  },
  methods: {
    getRoomDetails(rid) {
        this.$http.get('/api/room/'+rid, roomrequest)
            .then( resp => {
                console.log(resp);
            })
            .catch( error => {
                console.log(error);
            });
    },
  },
  mounted() {
    console.log(this.$route.params);
    this.roomid = this.$route.params['id'];
    this.getRoomDetails(this.roomid);
  }
}
</script>

<style>

</style>