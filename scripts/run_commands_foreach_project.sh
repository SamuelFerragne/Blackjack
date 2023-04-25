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

##### INCLUDE #####
this_dir=$(readlink -f "$0")
scripts_dir=$(dirname "$this_dir")
. "$scripts_dir/include.sh"
###################

run_commands(){

    for command in "$@";
    do
        echo -n "[$run_commands_dir]$ "
        echo $command
        eval "${command}"
        echo ""
    done

}

save_dir

cd "$root_dir"

dirs=$(find . -maxdepth 2 -type d | tail -n+2 | grep -v "[.]/[.]" | grep -v "[.]/buildSrc" | uniq)

for dir in $dirs; 
do
    if [ -e "$dir"/build.gradle ];then
        cd $dir

        echo ""
        echo ""

        export run_commands_dir=$dir
        run_commands "$@"

        cd "$root_dir"

    fi
done

restore_dir
