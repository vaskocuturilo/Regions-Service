const { defineConfig } = require("cypress");

module.exports = defineConfig({

  viewportHeight: 1080,
  viewportWidth: 1920,
  "retries": {
    "runMode": 2,
    "openMode": 0
  },

  e2e: {
    setupNodeEvents(on, config) {
      if (config.env.master) {
        return {
          baseUrl: "",
          env: {
            env: "master"
          },
        };
      } else
        return {
          baseUrl: "http://localhost:8080",
          env: {
            env: "qa"
          },
        };
    },
  },
});
