<template>
    <header class="header-global">
        <base-nav class="navbar-main" transparent type="" effect="light" expand>
            <router-link slot="brand" class="navbar-brand mr-lg-5" to="/">
              <img src="img/brand/title.png">
            </router-link>

            <ul class="navbar-nav navbar-nav-hover align-items-lg-center">
                <base-dropdown class="nav-item" menu-classes="dropdown-menu-xl">
                  <a slot="title" href="#profile" class="nav-link" data-toggle="dropdown" role="button">
                    <span class="nav-link-inner--text">PROFILE</span>
                  </a>
                </base-dropdown>
                <base-dropdown tag="li" class="nav-item">
                    <a slot="title" href="#" class="nav-link" data-toggle="dropdown" role="button">
                        <span class="nav-link-inner--text">SKILL STACK</span>
                    </a>
                </base-dropdown>
            </ul>
            <ul class="navbar-nav align-items-lg-center ml-lg-auto">
                <li class="nav-item">
                    <a class="nav-link nav-link-icon" href="https://demos.creative-tim.com/vue-argon-design-system/documentation/" target="_blank"
                       data-toggle="tooltip" title="Visit my tistory">
                        <i class="fa fa-book"></i>
                        <span class="nav-link-inner--text d-lg-none">Tistory</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link nav-link-icon" href="https://www.instagram.com/creativetimofficial"
                       target="_blank" data-toggle="tooltip" title="Follow us on Facebook">
                        <i class="fa fa-facebook"></i>
                        <span class="nav-link-inner--text d-lg-none">Facebook</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link nav-link-icon" href="https://dhaudgkr.tistory.com" target="_blank"
                       data-toggle="tooltip" title="Visit my tistory">
                        <i class="fa fa-book"></i>
                        <span class="nav-link-inner--text d-lg-none">Tistory</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link nav-link-icon" href="https://github.com/dh37789"
                       target="_blank" data-toggle="tooltip" title="Star us on Github">
                        <i class="fa fa-github"></i>
                        <span class="nav-link-inner--text d-lg-none">Github</span>
                    </a>
                </li>
            </ul>
        </base-nav>
    </header>
</template>
<script>

import BaseNav from "@/components/BaseNav";
import CloseButton from "@/components/CloseButton";

export default {
  components: {
    BaseNav,
    CloseButton
  }
};
</script>
<style>
</style>
