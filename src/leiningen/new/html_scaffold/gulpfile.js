const path = require('path');
const glob = require('glob');
const gulp = require('gulp');

const gulpStylelint = require('gulp-stylelint');
const postcss = require('gulp-postcss');

const OUTPUT = path.resolve(__dirname, 'resources', 'public');

function swallowError(error) {
  console.log(error.toString());
  this.emit('end');
}

gulp.task('beautify', () =>
  gulp.src('resources/public/html/**/*.html')
    .pipe(require('gulp-jsbeautifier')({
      indent_size: 2,
      end_with_newline: true,
      indent_inner_html: true,
      unformatted: [],
    }))
    .pipe(gulp.dest(path.join(OUTPUT, 'html'))));

gulp.task('lint', () =>
  gulp.src('src/css/**/*.css')
      .pipe(gulpStylelint({
        reporters: [
          {
            formatter: 'string',
            console: true,
          }
        ],
        failAfterError: false,
      })));

gulp.task('css', () =>
  gulp.src(glob.sync('src/css/boo/views/**/*.css'))
      .pipe(postcss([
        require('postcss-import')(),
        require('postcss-cssnext')(),
        require('postcss-sorting'),
      ]))
      .on('error', swallowError)
      .pipe(gulp.dest(path.join(OUTPUT, 'css')))
);

gulp.task('watch', ['lint', 'css'], () => {
  gulp.watch('./src/css/**/*.css', ['lint', 'css']);
});

gulp.task('default', ['lint', 'css']);
