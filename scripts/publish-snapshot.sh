#!/usr/bin/env bash
VERSION_ARG=$1
BUILD_TIME=$(date -u +"%Y%m%d%H%M%S")
BUILD_VERSION=${VERSION_ARG:-"0.0.0-$BUILD_TIME"}
NPM_USER="$PUNI_NPM_USER" \
NPM_PASS="$PUNI_NPM_PASS" \
NPM_EMAIL="$PUNI_NPM_EMAIL" \
npx --yes npm-cli-login -r https://npm.puni.tw -s @puni

DIR=$(dirname $0)
ABS_PATH=$(cd "$DIR" && pwd)
DIST_TARGET="$ABS_PATH/../build/js"
MAJOR_PACKAGE="packages/ology-kt"

function publishLib() {
  package=$(cd "$DIST_TARGET/$1" && cat package.json | jq -r '.name')
  if [[ "$package" == kotlin-test* ]]; then
    echo "Skip $package"
    return 0
  fi
  (cd "$DIST_TARGET/$1" && npm version "$BUILD_VERSION" --no-git-tag-version && npm publish --registry=https://npm.puni.tw)
  (cd "$DIST_TARGET/$MAJOR_PACKAGE" && npm install add-dependencies "$package@$BUILD_VERSION" --ignore-scripts --registry=https://npm.puni.tw)
}

(cd "$DIST_TARGET" && cat package.json | jq -r '.workspaces[] | select(startswith("packages_imported"))' | while read -r package; do publishLib "$package"; done )

# add win-control to dist target
(cd "$DIST_TARGET/$MAJOR_PACKAGE" && npm install add-dependencies @zygarde-projects/win-control -f --ignore-scripts)

(cd "$DIST_TARGET/$MAJOR_PACKAGE" && npm version "$BUILD_VERSION" --no-git-tag-version && npm publish --registry=https://npm.puni.tw)
