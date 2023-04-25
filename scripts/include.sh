# Copyright (C) (2022) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)
#
# This file is part of Ntro
#
# Ntro is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# Ntro is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with aquiletour.  If not, see <https://www.gnu.org/licenses/>

export GRADLE_OPTS="-Dfile.encoding=utf-8" 

root_dir=$(dirname "$scripts_dir")

if uname | grep -q -i linux; then

    os="linux"

elif uname | grep -q -i mingw64; then

    os="windows"

else

    os="macos"

fi

home_dir="$HOME"

#uname=$(id | sed "s/uid=[0-9]\+(//" | sed "s/).*//")

#if [ "$os" = "windows" ]; then
    #home_dir="/c/Users/$uname"
#else
    #home_dir="$HOME"
#fi

project_cache_dir="$home_dir/.gradle_3c6"
gradle_args=--project-cache-dir='"'$project_cache_dir'"'" --continue "

save_dir(){

    current_dir=$(pwd)
}

restore_dir(){

    cd "$current_dir"
}




