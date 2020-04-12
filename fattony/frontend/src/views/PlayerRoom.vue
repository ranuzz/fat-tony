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
                        <strong>Leave Game</strong>
                    </a>
                </div>
            </b-navbar-item>
        </template>
    </b-navbar>
    <hr />
    <section>
        <div class="columns">
            <div class="column is-2"></div>
            <div class="column is-7">
                <video autoplay muted playsinline></video>
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
            <button class="button">Raise Hand</button>
            <button class="button">Yell!</button>
            <button class="button">Debate</button>
          </div>
        </div>
        <div class="column is-4">
          <div class="buttons has-addons">
            <button class="button">Special Action</button>
            <button class="button">Lock vote</button>
            <button class="button">Call for vote</button>
          </div>          
        </div>
        <div class="column is-3">
          <div class="buttons has-addons">
            <button class="button">Quit</button>
            <button class="button">Leave</button>
            <button class="button">Sleep</button>
          </div>
        </div>
        <div class="column is-1"></div>
      </div>
    </section>

 </div> 
</template>

<script>
export default {
    data() {
        return {
            playerid: 0
        };
    },
    methods: {
        getPlayerDetails(pid) {
            console.log("fetching player details");
        },
        startWebCam() {
            var constraints = { audio: true, video: { width: 640, height: 360 } }; 

            navigator.mediaDevices.getUserMedia(constraints)
                .then(function(mediaStream) {
                    var video = document.querySelector('video');
                    video.srcObject = mediaStream;
                    video.onloadedmetadata = function(e) {
                        video.play();
                    };
                })
                .catch(function(err) { console.log(err.name + ": " + err.message); });
        }
    },
    mounted() {
        console.log(this.$route.params);
        this.playerid = this.$route.params['id'];
        console.log('starting webcam');
        this.startWebCam();
    }
}
</script>

<style>

</style>