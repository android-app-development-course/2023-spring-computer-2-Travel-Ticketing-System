<template>
    <view>
        <view class="cu-bar bg-white flex justify-between align-center">
            <view class="padding-lr" :class="animation?'animation-slide-right' :''" @click="startClick()">
                {{start.name}}
            </view>
            <img style="width: 28px" mode="widthFix" src="../../../static/exchange.svg" @tap="toggle()"/>
            <view class="padding-lr" :class="animation?'animation-slide-left' :''" @click="endClick()">
                {{end.name}}
            </view>
        </view>
    </view>
</template>

<script>
    export default {
        name: "StartEndPoint",
        data() {
            return {
                animation: false,
                start: {name: "北京"},
                end: {name: "唐山"},
            }
        },
        methods: {
            toggle() {
                this.animation= true;
                setTimeout(()=>{
                    this.animation = false;
                }, 1000)
                let temp = null;
                temp = this.start;
                this.start = this.end;
                this.end = temp;
            },
            startClick() {
                this.$emit('startClick');
            },
            endClick() {
                this.$emit('endClick');
            }
        }
    }
</script>

<style>

</style>
