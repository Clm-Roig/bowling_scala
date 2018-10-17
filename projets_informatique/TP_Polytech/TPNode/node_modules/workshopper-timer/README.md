# workshopper-timer

Makes sure the submission of a workshop executes for around the same duration
as the solution.

[![Dependency Status](https://img.shields.io/david/TimothyGu/workshopper-timer.svg)](https://david-dm.org/TimothyGu/workshopper-timer)
[![NPM version](https://img.shields.io/npm/v/workshopper-timer.svg)](https://www.npmjs.org/package/workshopper-timer)

## Installation

    npm install --save workshopper-timer

## Usage

```js
var exercise = require('workshopper-exercise')();
var filecheck = require('workshopper-exercise/filecheck');
var execute = require('workshopper-exercise/execute');
var comparestdout = require('workshopper-exercise/comparestdout');

var timer = require('workshopper-timer');

exercise = filecheck(exercise);
exercise = execute(exercise);
exercise = comparestdout(exercise);

// 100 = threshold in ms
exercise = timer(exercise, 100);

module.exports = exercise;
```

## License

MIT
