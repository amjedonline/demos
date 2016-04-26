#!/bin/sh

if [[ "$1" = "live" || "$1" = "staging" ]]; then
    echo "hello"
else
    echo "Please specify the enviornment to release to (live/staging)."
    exit;
fi
