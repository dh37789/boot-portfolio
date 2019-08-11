<template>
    <footer class="footer has-cards">
        <div class="container">
            <div class="row row-grid align-items-center my-md">
                <!-- <div class="col-lg-6"> -->
                    <!-- <h3 class="text-primary font-weight-light mb-2">감사합니다!!</h3>
                    <h4 class="mb-0 font-weight-light">Let's get in touch on any of these platforms.</h4> -->
                <!-- </div> -->
                <div class="col-lg-12 text-lg-right btn-wrapper">
                    <router-link rel="noopener" to="/login"
                       class="btn btn-neutral btn-icon-only btn-app btn-md btn-round" data-toggle="tooltip"
                       data-original-title="Follow us on Facebook">
                        <i class="fa fa-user"></i>
                    </router-link>
                    <a target="_blank" rel="noopener" href="https://dhaudgkr.tistory.com"
                       class="btn btn-neutral btn-icon-only btn-facebook btn-md btn-round" data-toggle="tooltip"
                       data-original-title="Follow us on Facebook">
                        <i class="fa fa-facebook"></i>
                    </a>
                    <a target="_blank" rel="noopener" href="https://www.notion.so/dh37789/Code-Note-19ded0b9506948f5a733bac65142d5fd"
                       class="btn btn-neutral btn-icon-only btn-dribbble btn-md btn-round" data-toggle="tooltip"
                       data-original-title="Welcome to my Coding Note">
                        <i class="fa fa-book"></i>
                    </a>
                    <a target="_blank" rel="noopener" href="https://github.com/dh37789"
                       class="btn btn-neutral btn-icon-only btn-github btn-round btn-md" data-toggle="tooltip"
                       data-original-title="Star on Github">
                        <i class="fa fa-github"></i>
                    </a>
                </div>
            </div>
            <hr>
            <div class="row align-items-center justify-content-md-between">
                <div class="col-md-6">
                    <div class="copyright">
                        &copy; {{year}}
                        <a href="#" target="_blank" rel="noopener">MyeongHak Oh</a>
                    </div>
                </div>
                <!-- <div class="col-md-6">
                    <ul class="nav nav-footer justify-content-end">
                        <li class="nav-item">
                            <a href="https://www.creative-tim.com" class="nav-link" target="_blank">Creative Tim</a>
                        </li>
                        <li class="nav-item">
                            <a href="https://www.creative-tim.com/presentation" class="nav-link" target="_blank">About
                                Us</a>
                        </li>
                        <li class="nav-item">
                            <a href="http://blog.creative-tim.com" class="nav-link" target="_blank">Blog</a>
                        </li>
                        <li class="nav-item">
                            <a href="https://github.com/creativetimofficial/argon-design-system/blob/master/LICENSE.md"
                               class="nav-link" target="_blank">MIT License</a>
                        </li>
                    </ul>
                </div> -->
            </div>
        </div>
    </footer>
</template>
<script>
export default {
  name: 'starter-footer',
  data() {
    return {
      year: new Date().getFullYear()
    }
  }
};
</script>
<style>
</style>
