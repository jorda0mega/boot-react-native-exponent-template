'use strict';

// hack: get reagent to find ReactNative.render as ReactDOM.render
global.ReactDOM = require('react-native');

require('./build/main.js');
example.core.main();