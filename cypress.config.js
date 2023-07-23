const { defineConfig } = require("cypress");
const allureWriter = require('@shelex/cypress-allure-plugin/writer');

module.exports = defineConfig({

  viewportHeight: 1080,
  viewportWidth: 1920,
  "video": false,
  "retries": {
    "runMode": 2,
    "openMode": 0
  },

  e2e: {
    setupNodeEvents(on, config) {
      allureWriter(on, config);
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
