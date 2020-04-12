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
                <div class="faceapidisplay">
                      <video autoplay="true" id="inputVideo"></video>
                      <canvas id="overlay" width="416" height="416" />
                </div>
                <!--<video autoplay muted playsinline></video>-->
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
                   Voting Arena
                </p>
                <a class="card-header-icon">
                    <b-icon
                        :icon="props.open ? 'menu-down' : 'menu-up'">
                    </b-icon>
                </a>
            </div>
            <div class="card-content">
                <div class="content">
                    <ul id="example-1">
                        <li v-for="item in players" :key="item.playerid">
                            {{ item.name }}
                            <div v-if="item.name === player_name">
                                <b-tag type="is-info">It's Me</b-tag>
                            </div>
                            <div v-if="item.dead">
                                <b-tag type="is-info">Dead !</b-tag>
                            </div>
                            <div v-if="!item.dead && item.name !== player_name">
                                <button class="button" @click="postVote(item);">Vote</button>
                            </div>
                        </li>
                    </ul>
                </div>
            </div>
        </b-collapse>

            </div>
            <div class="column is-1"></div>
        </div>
    </section>
    <br />
    <br />
    <br />
    <br />
    <br />
    <br />
    <hr />
        <section>
        <div class="columns">
            <div class="column is-1"></div>
            <div class="column is-10">
                    <b-taglist>
        <b-tag type="is-info">Name:{{player_name}}</b-tag>
        <b-tag type="is-info">Dead:{{player_dead}}</b-tag>
        <b-tag type="is-info">Role:{{player_role}}</b-tag>
        <b-tag type="is-info">EyeOpen:{{player_aankh}}</b-tag>
        <b-tag type="is-info">Voted For:{{player_voted_for}}</b-tag>
    </b-taglist>
            </div>
            <div class="column is-1"></div>
        </div>

    </section>
    <section>
        <div class="columns">
            <div class="column is-1"></div>
            <div class="column is-10">
                        <b-taglist>
            
            <b-tag type="is-info">Key: {{room_key}}</b-tag>
            <b-tag type="is-info">Max Players: {{room_player_count}}</b-tag>
            <b-tag type="is-info">Game type: {{room_game_type}}</b-tag>
            <b-tag type="is-info">Joined: {{players.length}}</b-tag>
        </b-taglist>
            </div>
            <div class="column is-1"></div>
        </div>

    </section>
    <section>
      <div class="columns">
        <div class="column is-1"></div>
        <div class="column is-3">
          <div class="buttons has-addons">
            <button class="button" @click="getRoomPlayer">Get Players</button>
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

import * as faceapi from 'face-api.js';

export default {
    data() {
        return {
            playerid: 0,
            player_name: '',
            player_role: '',
            player_dead: false,
            player_aankh: false,
            player_voted_for: -1,
            room_id: -1,
            room_name: '',
            room_player_count: 0,
            room_rules: '',
            room_game_type: '',
            room_key: '',
            players: []
        };
    },
    methods: {

        snackbar(msg) {
            this.$buefy.snackbar.open(msg);
        },
        getGameDetails(gid) {
            console.log("fetching game details");
            this.snackbar("fetching room details");
            this.$http.get("/api/room/"+gid)
                .then(resp => {
                    console.log(resp);
                    this.room_id = resp.data.roomid;
                    this.room_name = resp.data.name;
                    this.room_player_count = resp.data.numplayers;
                    this.room_rules = resp.data.rules;
                    this.room_game_type = resp.data.gametype;
                    this.room_key = resp.data.roomkey;
                })
                .catch(error => {
                    console.log(error);
                    this.snackbar("Room Fetch failed");
                });
        },
        postVote(p) {
            if (p.dead) {
                this.snackbar("Player died already : " + p.name);
            } else {
                let prequest = {
                    plpayerid: parseInt(this.playerid),
                    vote: p.playerid,
                }
                this.snackbar("Casting vote to player : " + p.name);
                this.$http.patch("/api/player/update", prequest)
                    .then(resp => {
                        console.log(resp);
                        this.getPlayerDetails(this.playerid);
                    })
                    .catch(error => {
                        console.log(error);
                    });
            }
        },
        getRoomPlayer() {
            setTimeout(() => this.getRoomPlayer(), 1000);
            if (this.room_id === -1) {
                return;
            }
            this.$http.get("/api/player/room/"+this.room_id)
                .then(resp => {
                    this.players = resp.data;
                    console.log(resp);
                    //this.snackbar("Current Joined players : "+ this.players.length);
                })
                .catch(error => {
                    console.log(error);
                })
        },
        getPlayerDetails(pid) {
            console.log("fetching player details");
            this.snackbar("Fetching player details : " + this.playerid);
            this.$http.get("/api/player/"+this.playerid)
                .then(resp => {
                    console.log(resp);
                    this.player_name = resp.data.name;
                    this.player_role = resp.data.role;
                    this.player_dead = resp.data.dead;
                    this.player_aankh = resp.data.sight;
                    this.player_voted_for = resp.data.vote;
                    this.getGameDetails(resp.data.roomid);
                })
                .catch(error => {
                    console.log(error);
                    this.snackbar("Player detail fetch failed");
                });
        },
        updatePlayerDetails(prequest) {
            this.snackbar("Updating Player Data");
            this.$http.patch("/api/player/update", prequest)
                .then(resp => {
                    console.log(resp);
                })
                .catch(error => {
                    console.log(error);
                    this.snackbar("Plpayer Update Faield");
                });
        },
        startWebCam() {
            var constraints = { audio: true, video: { width: 416, height: 416 } }; 

            navigator.mediaDevices.getUserMedia(constraints)
                .then(function(mediaStream) {
                    var video = document.querySelector("#inputVideo");
                    video.srcObject = mediaStream;
                    video.onloadedmetadata = function(e) {
                        video.play();
                    };
                })
                .catch(function(err) { console.log(err.name + ": " + err.message); });
        },
        loadfaceapi() {
            faceapi.nets.tinyFaceDetector.load('/models');
            faceapi.loadFaceLandmarkModel('/models');
        },
        async onPlay(videoEl) {
            if(!videoEl.currentTime || videoEl.paused || videoEl.ended)
                return setTimeout(() => this.onPlay(videoEl))

            const options = new faceapi.TinyFaceDetectorOptions()

            const ts = Date.now()

            let task = faceapi.detectAllFaces(videoEl, options)
            task = task.withFaceLandmarks()
            const results = await task

            const canvas = document.querySelector('#overlay')
            const dims = faceapi.matchDimensions(canvas, videoEl, true)

            const resizedResults = faceapi.resizeResults(results, dims)

            function calculate_ear(eye){
                return (dist(eye[1], eye[5]) + dist(eye[2], eye[4])) / (2.0 * dist(eye[0], eye[3]));
            }

            function dist(arr1, arr2) {
                return Math.sqrt(Math.pow((arr1[0]-arr2[0]), 2) + Math.pow((arr1[1]-arr2[1]), 2));
            }
            
            if (resizedResults.length) {
                if (resizedResults[0].landmarks !== undefined){
                    let landmarks = resizedResults[0].landmarks._positions;
                    let leftEye = [[landmarks[42]._x, landmarks[42]._y], [landmarks[43]._x, landmarks[43]._y], [landmarks[44]._x, landmarks[44]._y], [landmarks[45]._x, landmarks[45]._y], [landmarks[46]._x, landmarks[46]._y], [landmarks[47]._x, landmarks[47]._y]]
                    let rightEye = [[landmarks[36]._x, landmarks[36]._y], [landmarks[37]._x, landmarks[37]._y], [landmarks[38]._x, landmarks[38]._y], [landmarks[39]._x, landmarks[39]._y], [landmarks[40]._x, landmarks[40]._y], [landmarks[41]._x, landmarks[41]._y]]
                    let ear = (calculate_ear(leftEye) + calculate_ear(rightEye))/2.0;
                    console.log(ear);
                }
            }
            faceapi.draw.drawDetections(canvas, resizedResults)
            faceapi.draw.drawFaceLandmarks(canvas, resizedResults)

            setTimeout(() => this.onPlay(videoEl))
        },
    },
    mounted() {
        console.log(this.$route.query);
        this.playerid = this.$route.query['id'];
        console.log('starting webcam');
        this.getPlayerDetails(this.playerid);
        this.startWebCam();
        this.loadfaceapi();
        this.onPlay(document.querySelector("#inputVideo"));
        this.getRoomPlayer();
        
    }
}
</script>

<style>

.faceapidisplay {
    position: relative;
}

#inputVideo {
    position: absolute;
}
#overlay {
    position: absolute;
}

</style>